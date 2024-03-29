package ru.elipson.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import ru.elipson.composition.R
import ru.elipson.composition.databinding.FragmentChooseLevelBinding
import ru.elipson.composition.databinding.FragmentWelcomeBinding
import ru.elipson.composition.domain.entity.Level

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("ChooseLevelFragment = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            testLevel.setOnClickListener {
                openGameFragment(Level.Test)
            }
            easyLevel.setOnClickListener {
                openGameFragment(Level.Easy)
            }
            normalLevel.setOnClickListener {
                openGameFragment(Level.Normal)
            }
            hardLevel.setOnClickListener {
                openGameFragment(Level.Hard)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun openGameFragment(level: Level) {
        findNavController().navigate(
            ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(
                level
            )
        )
        /*requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fcvView, GameFragment.newInstance(level))
            .addToBackStack(GameFragment::class.java.simpleName)
            .commit()*/
    }

}