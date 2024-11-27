package com.hongstudio.androidarchitecturesample

data class Product(val name: String, val price: Double) {

    // 할인 금액 계산 로직
    fun calculateDiscountedPrice(): Double {
        return if (price >= 1000) {
            price * 0.9 // 10% 할인 적용
        } else {
            price // 할인 없음
        }
    }
}

