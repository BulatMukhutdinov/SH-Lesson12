package tat.mukhutdinov.raceTracker

import tat.mukhutdinov.raceTracker.ui.RaceParticipant

class RaceParticipantTest {
    private val raceParticipant = RaceParticipant(
        name = "Test",
        maxProgress = 100,
        progressDelayMillis = 500L,
        initialProgress = 0,
        progressIncrement = 1
    )
}
