package com.hongstudio.androidarchitecturesample

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 버튼 클릭 이벤트 처리
        findViewById<Button>(R.id.calculateDiscountButton).setOnClickListener {
            val productName = findViewById<EditText>(R.id.productNameInput).text.toString()
            val productPrice =
                findViewById<EditText>(R.id.productPriceInput).text.toString().toDoubleOrNull()

            if (productPrice != null) {
                product = Product(productName, productPrice)

                // Model의 로직 호출 및 UI 업데이트
                val discountedPrice = product.calculateDiscountedPrice()
                showDiscountedPrice(product.name, discountedPrice)
            } else {
                showError("유효한 가격을 입력하세요.")
            }
        }
    }

    // 할인된 가격을 화면에 표시
    private fun showDiscountedPrice(name: String, discountedPrice: Double) {
        findViewById<TextView>(R.id.resultTextView).text =
            "상품: $name, 할인된 가격: ${"%.2f".format(discountedPrice)}원"
    }

    // 에러 메시지 표시
    private fun showError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }
}

