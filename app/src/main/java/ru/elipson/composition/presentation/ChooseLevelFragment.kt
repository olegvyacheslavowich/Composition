package ru.elipson.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.elipson.composition.R
import ru.elipson.composition.databinding.FragmentChooseLevelBinding
import ru.elipson.composition.databinding.FragmentWelcomeBinding
import ru.elipson.composition.domain.entity.Level

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    val binding get() = _binding ?: throw RuntimeException("ChooseLevelFragment = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.testLevel.setOnClickListener {
            openGameFragment(Level.Test)
        }

        binding.easyLevel.setOnClickListener {
            openGameFragment(Level.Easy)
        }

        binding.normalLevel.setOnClickListener {
            openGameFragment(Level.Normal)
        }

        binding.hardLevel.setOnClickListener {
            openGameFragment(Level.Hard)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun openGameFragment(level: Level) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fcvView, GameFragment.newInstance(level))
            .addToBackStack(null)
            .commit()
    }

    companion object {

        fun newIntent(): ChooseLevelFragment = ChooseLevelFragment()

    }
}