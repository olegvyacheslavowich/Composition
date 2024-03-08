package ru.elipson.composition.presentation

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.elipson.composition.databinding.FragmentGameFinishedBinding
import ru.elipson.composition.domain.entity.GameResult

class GameFinishedFragment : Fragment() {

    private val args by navArgs<GameFinishedFragmentArgs>()
    private lateinit var gameResult: GameResult
    private var _binding: FragmentGameFinishedBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("GameFinishedFragment = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater)

        requireActivity().onBackPressedDispatcher.addCallback() {
            retryGame()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("lifecycle", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle", "onDestroy")
    }

    private fun retryGame() {
        findNavController().popBackStack()
        /*requireActivity().supportFragmentManager.popBackStack(
            GameFragment::class.simpleName,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gameResult = args.gameResult
    }
}