package com.hongstudio.androidarchitecturesample

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var controller: ProductController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Controller 초기화
        controller = ProductController(this)

        // 버튼 클릭 시 할인 계산 요청
        findViewById<Button>(R.id.calculateDiscountButton).setOnClickListener {
            val productName = findViewById<EditText>(R.id.productNameInput).text.toString()
            val productPrice = findViewById<EditText>(R.id.productPriceInput).text.toString().toDoubleOrNull()

            if (productPrice != null) {
                controller.calculateDiscount(productName, productPrice)
            } else {
                showError("유효한 가격을 입력하세요.")
            }
        }
    }

    // 할인된 가격을 화면에 표시
    fun showDiscountedPrice(name: String, discountedPrice: Double) {
        findViewById<TextView>(R.id.resultTextView).text =
            "상품: $name, 할인된 가격: ${"%.2f".format(discountedPrice)}원"
    }

    // 에러 메시지 표시
    fun showError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }
}
