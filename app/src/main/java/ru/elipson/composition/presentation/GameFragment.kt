package ru.elipson.composition.presentation

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.elipson.composition.R
import ru.elipson.composition.databinding.FragmentGameBinding
import ru.elipson.composition.domain.entity.GameResult
import ru.elipson.composition.domain.entity.GameSettings
import ru.elipson.composition.domain.entity.Level

class GameFragment : Fragment() {

    private lateinit var level: Level
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentGameBinding = null")
    private lateinit var viewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[GameViewModel::class.java]
        _binding = FragmentGameBinding.inflate(inflater)

        binding.tvSum.setOnClickListener {
            openGameFinishedFragment()
        }

        viewModel.timeLiveData.observe(viewLifecycleOwner) {
            with(binding) {
                tvTimer.text = it.gameTimeInSec.toString()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs() {
        level = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable(KEY_LEVEL, Level::class.java)
        } else {
            requireArguments().getParcelable(KEY_LEVEL)
        } ?: throw RuntimeException("Illegal parameter exception = $KEY_LEVEL")
    }

    private fun openGameFinishedFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(
                R.id.fcvView,
                GameFinishedFragment.newInstance(GameResult(gameSetting = GameSettings()))
            )
            .addToBackStack(null)
            .commit()
    }

    companion object {

        private const val KEY_LEVEL = "level"
        fun newInstance(level: Level) =
            GameFragment().apply {
                arguments = bundleOf(
                    KEY_LEVEL to level
                )
            }
    }
}