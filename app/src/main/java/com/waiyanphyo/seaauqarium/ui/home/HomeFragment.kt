package com.waiyanphyo.seaauqarium.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.waiyanphyo.seaauqarium.R
import com.waiyanphyo.seaauqarium.data.Button
import com.waiyanphyo.seaauqarium.data.UpcomingShow
import com.waiyanphyo.seaauqarium.databinding.FragmentHomeBinding
import com.waiyanphyo.seaauqarium.ui.ButtonAdapter
import com.waiyanphyo.seaauqarium.ui.UpcomingShowAdapter
import com.waiyanphyo.seaauqarium.ui.composeComponents.ButtonGrid


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var upcomingShowAdapter: UpcomingShowAdapter
    private lateinit var buttonAdapter: ButtonAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        buttonAdapter = ButtonAdapter(requireContext())
        upcomingShowAdapter = UpcomingShowAdapter(requireContext())

        binding.rvButtons.adapter = buttonAdapter
        binding.rvUpcomingShow.adapter = upcomingShowAdapter

        val buttons = listOf(
            Button(R.drawable.ic_map, "Map"),
            Button(R.drawable.ic_inhabitants, "Inhabitants"),
            Button(R.drawable.ic_shows, "Shows"),
            Button(R.drawable.ic_shopping, "Shopping"),
            Button(R.drawable.ic_dines, "Dine"),
            Button(R.drawable.ic_meet_and_greets, "Meet & Greets"),
        )
        buttonAdapter.submitList(buttons)

        upcomingShowAdapter.submitList(listOf(
            UpcomingShow(
                time = "2:30 PM",
                title = "Alligator gar",
                image = R.drawable.alligator_gar,
                distance = "410m",
                description = "The alligator gar (Atractosteus spatula) is a large, prehistoric-looking fish native to the southeastern United States. It is known for its distinctive appearance, with long, cylindrical bodies covered in thick, armor-like scales. Some individuals can grow to over 10 feet in length and weigh several hundred pounds. Their snouts resemble those of alligators, with rows of sharp teeth. Alligator gars primarily inhabit slow-moving freshwater systems, such as rivers, bayous, lakes, and swamps, and prefer warm, murky waters with aquatic vegetation and submerged structures. These predatory fish have a diverse diet, preying on smaller fish, waterfowl, and invertebrates. They are solitary and territorial by nature and often use ambush tactics to capture their prey.")
        ))

        val sliders = HashMap<String, Int>()
        sliders["Don't miss our daily Dive Feeding!"] = R.drawable.dive_slide
        sliders["Say Cheese with Sharks!"] = R.drawable.shark
        for (name in sliders.keys) {
            val textSliderView = TextSliderView(requireContext())
            // initialize a SliderLayout
            textSliderView
                .description(name)
                .image(sliders[name]!!).scaleType = BaseSliderView.ScaleType.Fit

            //add your extra information
            textSliderView.bundle(Bundle())
            textSliderView.bundle
                .putString("extra", name)
            binding.bannerSlider.addSlider(textSliderView)
        }
        binding.bannerSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)

        upcomingShowAdapter.setOnItemClickListener {
            findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToSliderDetailFragment(it))
        }

//        binding.composeView.setContent {
//
//            MaterialTheme {
//                Surface(
//                    Modifier.nestedScroll(rememberNestedScrollInteropConnection())
//                ) {
//                    ButtonGrid(buttons = buttons, modifier = Modifier.fillMaxWidth()) {buttonText ->
//                        Toast.makeText(requireContext(), buttonText, Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//            }
//        }

        return root
    }

    override fun onStop() {
        _binding?.bannerSlider?.stopAutoCycle()
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}