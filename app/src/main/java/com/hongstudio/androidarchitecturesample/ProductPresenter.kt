package com.hongstudio.androidarchitecturesample

class ProductPresenter(
    private val view: ProductContract.View,
    private val model: ProductContract.Model
) : ProductContract.Presenter {

    override fun onCalculateButtonClick(name: String, price: Double?) {
        if (name.isBlank() || price == null || price <= 0) {
            view.showError("유효한 상품명과 가격을 입력하세요.")
            return
        }

        // 비즈니스 로직 호출: 할인 금액 계산
        val discountedPrice = model.calculateDiscountedPrice(name, price)

        // View에 결과 전달
        view.showDiscountedPrice(name, discountedPrice)
    }
}