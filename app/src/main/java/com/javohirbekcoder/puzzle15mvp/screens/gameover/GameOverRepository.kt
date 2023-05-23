package com.javohirbekcoder.puzzle15mvp.screens.gameover

import android.R.attr.duration
import android.content.Context
import com.javohirbekcoder.puzzle15mvp.database.HighscoreDatabase
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit


/*
Created by Javohirbek on 21.05.2023 at 11:13
*/
class GameOverRepository(private val context: Context) : GameOverContract.Repository {
    override fun getDatabaseInstance(): HighscoreDatabase {
        return HighscoreDatabase(context)
    }

    override fun getPartyAnimation(): Party {
        return Party(
            speed = 0f,
            maxSpeed = 30f,
            damping = 0.9f,
            spread = 360,
            colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
            emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
            position = Position.Relative(0.5, 0.3)
        )
    }
}