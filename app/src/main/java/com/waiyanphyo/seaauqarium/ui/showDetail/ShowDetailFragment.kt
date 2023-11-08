package com.waiyanphyo.seaauqarium.ui.showDetail

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.color
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.waiyanphyo.seaauqarium.R
import com.waiyanphyo.seaauqarium.databinding.FragmentShowDetailBinding

class ShowDetailFragment : Fragment() {

    private var _binding: FragmentShowDetailBinding? = null
    private val args by navArgs<ShowDetailFragmentArgs>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowDetailBinding.inflate(inflater, container, false)

        with(binding) {
            tvTitle.text = args.upcomingShow.title
            ivImage.setImageDrawable(ResourcesCompat.getDrawable(resources, args.upcomingShow.image, requireActivity().theme))
            val distance = SpannableStringBuilder()
                .append(args.upcomingShow.distance)
                .append(" away ")
                .color(resources.getColor(R.color.red, requireActivity().theme)) { append("Map") }
            tvDistance.text = distance.toString()
            tvDescription.text = args.upcomingShow.description
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}