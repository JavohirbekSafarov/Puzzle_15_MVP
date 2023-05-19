package com.javohirbekcoder.puzzle15mvp.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.javohirbekcoder.puzzle15mvp.R
import com.javohirbekcoder.puzzle15mvp.databinding.FragmentGameBinding
import kotlin.math.abs

class GameFragment : Fragment(R.layout.fragment_game), GameContract.View {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    private lateinit var presenter: GameContract.Presenter

    private val cell = Array(4) {
        arrayOfNulls<TextView>(4)
    }

    private var isGameActive = true

    private var moves = 0

    private var emptyX = 0
    private var emptyY = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater)

        binding.pauseBtn.apply {
            setOnClickListener {
                if (this.text.toString() == "Pause") {
                    this.text = "Continue"
                    binding.pauseLayout.visibility = View.VISIBLE

                    //Game Paused logic
                    binding.chronometer.stop()

                } else {
                    this.text = "Pause"
                    binding.pauseLayout.visibility = View.INVISIBLE

                    //Game continue logic
                    binding.chronometer.start()

                }
            }
        }
        binding.pauseLayout.setOnClickListener {
            binding.pauseBtn.callOnClick()
        }
        binding.newGameBtn.setOnClickListener {
            presenter.shuffle()
        }
        return binding.root
    }

    private fun canMove(clickedY: Int, clickedX: Int): Boolean =
        (abs(emptyY - clickedY) == 0 && abs(emptyX - clickedX) == 1 || abs(emptyY - clickedY) == 1 && abs(
            emptyX - clickedX
        ) == 0)

    private fun swap(clickedX: Int, clickedY: Int) {
        updateMovementUI(++moves)

        cell[emptyY][emptyX]?.apply {
            text = cell[clickedY][clickedX]?.text.toString()
            visibility = View.VISIBLE
        }

        cell[clickedY][clickedX]?.apply {
            visibility = View.INVISIBLE
            text = ""
        }
        emptyX = clickedX
        emptyY = clickedY
    }

    private fun updateMovementUI(moves: Int) {
        binding.movesTv.text = moves.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = GamePresenter(GameRepository(), this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun init() {
        binding.chronometer.start()
    }

    override fun loadViewsAndHandleClicks() {
        for (i in 0 until binding.gridLayout.childCount) {
            val y = i / 4
            val x = i % 4
            cell[y][x] = binding.gridLayout.getChildAt(i) as TextView
            cell[y][x]?.apply {
                setOnClickListener {
                    if (canMove(y, x)) {
                        swap(x, y)
                    }
                }
            }
        }
    }

    override fun loadGame(list: List<Int>) {
        for (i in 0 until binding.gridLayout.childCount) {
            if (list[i] == 16) {
                cell[i / 4][i % 4]?.visibility = View.INVISIBLE
                emptyY = i / 4
                emptyX = i % 4
                continue
            }
            cell[i / 4][i % 4]?.apply {
                visibility = View.VISIBLE
                text = list[i].toString()
            }
        }
    }

    override fun isGameOver(): Boolean {
        return false
    }
}