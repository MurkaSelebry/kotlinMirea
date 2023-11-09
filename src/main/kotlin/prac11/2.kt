package prac11

data class Product<T>(
    var name: String = "",
    var price: Double= 0.0,
    var description: String="",
    var category: T? = null
)
class Catalog<T> {
    private val products = mutableListOf<Product<T>>()

    fun addProduct(product: Product<T>) {
        products.add(product)
    }

    fun printProducts() {
        products.forEach { println(it) }
    }

    fun findProductByName(name: String): Product<T>? {
        return products.find { it.name == name }
    }
    fun filterByPrice(maxPrice: Double): List<Product<T>> {
        return products.filter { it.price <= maxPrice }
    }
}

fun purchase(catalog: Catalog<*>, productName: String): String {
    val product = catalog.findProductByName(productName)
    return product?.let { "Вы купили ${it.name} за ${it.price}" }
        ?: "Продукт не найден"
}

fun main() {
    val productT = Product<String>().apply {
        name = "Laptop"
        price = 1500.0
        description = "High-performance laptop"
        category = "Electronics"
    }
    val catalog = Catalog<String>().apply {
        addProduct(productT)

        addProduct(Product<String>().apply {
            name = "Smartphone"
            price = 800.0
            description = "High-quality smartphone"
            category = "Electronics"
        })

        addProduct(Product<String>().apply {
            name = "Shirt"
            price = 50.0
            description = "Comfortable shirt"
            category = "Clothing"
        })
    }


    catalog.printProducts()

    val product = catalog.findProductByName("Laptop")
    println(product)

    val filteredProducts = catalog.filterByPrice(1000.0)
    filteredProducts.forEach { println(it) }

    println(purchase(catalog, "Laptop"))
}
