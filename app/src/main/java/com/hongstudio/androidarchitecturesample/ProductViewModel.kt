package com.hongstudio.androidarchitecturesample

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductViewModel: ViewModel() {

    private val _product: MutableStateFlow<Product?> = MutableStateFlow(null)
    val product = _product.asStateFlow()

    private val _errorMessage: MutableStateFlow<String?> = MutableStateFlow(null)
    val errorMessage = _errorMessage.asStateFlow()

    fun onCalculateButtonClick(name: String, price: Double?) {
        if (name.isBlank() || price == null || price <= 0) {
            _errorMessage.value = "유효한 상품명과 가격을 입력하세요."
            return
        }

        // 비즈니스 로직 호출: 할인 금액 계산
        // 그 후 상태값 변경
        _product.value = Product(name, Product.calculateDiscountedPrice(price))
    }
}