package com.javohirbekcoder.puzzle15mvp.screens.gameover


/*
Created by Javohirbek on 21.05.2023 at 11:15
*/
class GameOverPresenter(
    private val repository: GameOverContract.Repository,
    private val view: GameOverContract.View
): GameOverContract.Presenter{
    override fun saveToDatabase() {
        view.setHighScore(repository.getDatabaseInstance())
    }

    override fun startAnimation() {
        view.setPartyAnimation(repository.getPartyAnimation())
    }
}