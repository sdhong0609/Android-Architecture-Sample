package com.hongstudio.androidarchitecturesample

interface ProductContract {
    interface View {
        fun showDiscountedPrice(name: String, discountedPrice: Double)
        fun showError(message: String)
    }

    interface Model {
        fun calculateDiscountedPrice(name: String, price: Double): Double
    }

    interface Presenter {
        fun onCalculateButtonClick(name: String, price: Double?)
    }
}