package com.hongstudio.androidarchitecturesample

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ProductContract.View {

    private lateinit var presenter: ProductPresenter

    @Inject
    lateinit var model: ProductModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Presenter 초기화
        presenter = ProductPresenter(this, model)

        // 버튼 클릭 시 이벤트 처리
        findViewById<Button>(R.id.calculateDiscountButton).setOnClickListener {
            val productName = findViewById<EditText>(R.id.productNameInput).text.toString()
            val productPrice =
                findViewById<EditText>(R.id.productPriceInput).text.toString().toDoubleOrNull()

            presenter.onCalculateButtonClick(productName, productPrice)
        }
    }

    // 할인된 가격을 화면에 표시
    override fun showDiscountedPrice(name: String, discountedPrice: Double) {
        findViewById<TextView>(R.id.resultTextView).text =
            "상품: $name, 할인된 가격: ${"%.2f".format(discountedPrice)}원"
    }

    // 에러 메시지 표시
    override fun showError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }
}

