package com.test.equipe

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.test.core.AppDispatchers
import com.test.equipe.domain.GetEquipeFromIdUseCase
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@SmallTest
@RunWith(JUnit4::class)
class EquipeUnitTests {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var getEquipeFromIdUseCase: GetEquipeFromIdUseCase
    private lateinit var viewModel: EquipeViewModel
    private val appDispatchers = AppDispatchers(Dispatchers.Unconfined, Dispatchers.Unconfined)

    @Before
    fun setUp() {
        getEquipeFromIdUseCase = mockk()
        viewModel = EquipeViewModel(appDispatchers, getEquipeFromIdUseCase)
    }

    @Test
    fun `Salut bro`() {

    }

}