package com.example.madlevel5task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.madlevel5task2.R
import com.example.madlevel5task2.model.Game
import kotlinx.android.synthetic.main.add_game_fragment.*
import java.time.LocalDate
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddGameFragment : Fragment() {
    private val viewModel: GameViewModel by viewModels()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.add_game_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveFab.setOnClickListener {
            onAddGame()
        }
    }

    private fun onAddGame(){
        val game = Game(etTitle.text.toString(), etPlatform.text.toString(), Date(etYear.text.toString().toInt(), etMonth.text.toString().toInt(), etDateDay.text.toString().toInt()))
        viewModel.insertGame(game)
        findNavController().popBackStack()
    }
}