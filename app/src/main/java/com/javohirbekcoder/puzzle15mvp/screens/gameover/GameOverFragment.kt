package com.javohirbekcoder.puzzle15mvp.screens.gameover

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.javohirbekcoder.puzzle15mvp.R
import com.javohirbekcoder.puzzle15mvp.database.HighscoreDatabase
import com.javohirbekcoder.puzzle15mvp.database.HighscoreEntity
import com.javohirbekcoder.puzzle15mvp.databinding.FragmentGameOverBinding
import nl.dionsegijn.konfetti.core.Party

class GameOverFragment : Fragment(R.layout.fragment_game_over), GameOverContract.View {

    private var _binding: FragmentGameOverBinding? = null
    private val binding get() = _binding!!

    private val args: GameOverFragmentArgs by navArgs()

    private lateinit var presenter: GameOverContract.Presenter

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameOverBinding.inflate(inflater)

        presenter = GameOverPresenter(GameOverRepository(requireContext()), this)

        presenter.startAnimation()
        presenter.saveToDatabase()

        binding.movesText.text = "Congratulations! You won the game with ${args.moves} moves!"

        binding.exitBtn.setOnClickListener {
            //Chiqishdan oldin dialog korsatish kk
            requireActivity().finish()
        }

        binding.restartBtn.setOnClickListener {
            findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment)
        }

        binding.mainMenuBtn.setOnClickListener {

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun setPartyAnimation(party: Party) {
        binding.konfettiView.start(party)
    }

    override fun setHighScore(db: HighscoreDatabase) {
        val highScoreEntity = HighscoreEntity(0, args.moves)
        db.insert(highScoreEntity)
    }
}