package ru.netology;

public class ProductManager {private ProductRepository repository = new ProductRepository();

    public void add(Product product){
        repository.save(product);
    }

    public Product[] findAll(){
        return repository.findAll();
    }

    public void deleteById(int removeProductId){
        repository.deleteById(removeProductId);
    }

    // метод определения соответствия товара по запросу search
    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {

                int length = result.length + 1;
                Product[] tmp = new Product[length];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }

                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = product;

                result = tmp;
            }
        }
        return result;
    }
}
