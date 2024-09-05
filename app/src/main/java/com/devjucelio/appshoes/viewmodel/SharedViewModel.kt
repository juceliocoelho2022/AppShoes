package com.devjucelio.appshoes.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devjucelio.appshoes.model.ProductUiModel
import com.devjucelio.appshoes.screen.MainScreen
import com.devjucelio.appshoes.ui.theme.AppShoesTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {
    private val _selectedProduct = MutableStateFlow<ProductUiModel?>(null)
    val selectedProduct = _selectedProduct.asStateFlow()

    fun selectProduct(product: ProductUiModel) {
        viewModelScope.launch {
            _selectedProduct.value = product
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    AppShoesTheme {
        MainScreen()
    }
}