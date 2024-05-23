### Abstract Factory

-------------------

Example: Phone store -> Phone Brands (Apple, Samsung, OnePlus) -> Concrete Model(iPhone 14, S23 Ultra, One Plus 11 Nord)

### Components of Abstract Factory Design Pattern

1. **Abstract Factory:** This is the main interface that declares a set of creation methods for creating the abstract products. It serves as a contract for concrete factories to implement. The abstract factory typically represents a family of related products. 
2. **Concrete Factory:** These are the implementations of the abstract factory interface. Each concrete factory is responsible for creating a specific set of products, which are compatible within a specific variation or family. 
3. **Abstract Product:** This represents the interface of the products that the abstract factory creates. It defines a set of operations that concrete products must implement. 
4. **Concrete Product:** These are the actual product implementations created by concrete factories. Each concrete factory creates a different variant of the product by implementing the abstract product interface.