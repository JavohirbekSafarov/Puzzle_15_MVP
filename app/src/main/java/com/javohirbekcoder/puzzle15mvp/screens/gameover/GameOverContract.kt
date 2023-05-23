package com.javohirbekcoder.puzzle15mvp.screens.gameover

import com.javohirbekcoder.puzzle15mvp.database.HighscoreDatabase
import nl.dionsegijn.konfetti.core.Party


/*
Created by Javohirbek on 21.05.2023 at 11:05
*/
interface GameOverContract {
    interface Presenter {
        fun saveToDatabase()
        fun startAnimation()
    }

    interface View {
        fun setPartyAnimation(party: Party)
        fun setHighScore(db: HighscoreDatabase)
    }

    interface Repository {
        fun getDatabaseInstance(): HighscoreDatabase
        fun getPartyAnimation(): Party
    }
}