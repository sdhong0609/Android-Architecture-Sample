package com.hongstudio.androidarchitecturesample

class ProductModel : ProductContract.Model {

    // 할인 금액 계산 로직
    override fun calculateDiscountedPrice(name: String, price: Double): Double {
        return if (price >= 1000) {
            price * 0.9 // 10% 할인 적용
        } else {
            price // 할인 없음
        }
    }
}

