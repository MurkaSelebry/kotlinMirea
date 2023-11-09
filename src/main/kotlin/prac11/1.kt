package prac11

data class ProductV(val name: String, val cost: Double)

enum class OrderStatus {
    CREATED, PROCESSING, DELIVERED, CANCELLED
}

class Order(){
    val products: MutableList<ProductV> = emptyList<ProductV>().toMutableList()
    var status: OrderStatus = OrderStatus.CREATED
    fun processOrder(newStatus: OrderStatus) = apply{
        this.status = newStatus
    }
    fun countDiscount() = run{
        println("Размер скидки: ${this.products.count()}%")
        products.count()/100
    }
    fun addProduct(product: ProductV)= with(products){
        add(product)
    }
}

fun main(){
    var o: Order? = null

    val newO = o?.let{it.processOrder(OrderStatus.CREATED)}

    o = Order().apply {
        this.status = OrderStatus.PROCESSING
    }
    o.run{this.addProduct(ProductV("Product1",100.0))}
    o.also{it.countDiscount()}

}