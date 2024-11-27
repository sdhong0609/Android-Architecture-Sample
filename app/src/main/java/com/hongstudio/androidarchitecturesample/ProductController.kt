package com.hongstudio.androidarchitecturesample

class ProductController(private val view: MainActivity) {

    fun calculateDiscount(name: String, price: Double) {
        // Model 생성
        val product = Product(name, price)

        // 도메인 로직 호출: 할인 금액 계산
        val discountedPrice = product.calculateDiscountedPrice()

        // View에 결과 전달
        view.showDiscountedPrice(product.name, discountedPrice)
    }
}
