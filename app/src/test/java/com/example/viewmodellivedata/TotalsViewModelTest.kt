package com.example.viewmodellivedata

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.viewmodellivedata.data.viewmodels.TotalsViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TotalsViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var totalsViewModel: TotalsViewModel

    @Before
    fun setUp() {
        totalsViewModel = TotalsViewModel()
        assertEquals(0, totalsViewModel.getTotal().value)
    }

    @Test
    fun increaseTotal() {
        val total = 5
        for (i in 0 until total) {
            totalsViewModel.increaseTotal()
        }

        assertEquals(5, totalsViewModel.getTotal().value)
    }
}