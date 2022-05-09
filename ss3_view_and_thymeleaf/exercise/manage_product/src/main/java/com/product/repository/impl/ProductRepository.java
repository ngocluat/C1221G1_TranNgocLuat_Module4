package com.product.repository.impl;

import com.product.model.Product;
import com.product.repository.BaseRepository;
import com.product.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {


    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "bánh", "Bánh Ngọt", 129.5));
        productList.add(new Product(2, "kẹo", "mút KHổng lồ ", 129.5));
        productList.add(new Product(3, "điện thoại", "Iphone 11 ", 444d));
        productList.add(new Product(4, "bình nước ", "10 lít ", 687.5));
    }

//    @Override
//    public List<Product> findAll() {
//        return productList;
//    }

//    @Override
//    public void save(Product product) {
//
//        int idIncreaseAuto;
//
//        if (productList.size() == 0) {
//            idIncreaseAuto = 1;
//        } else {
//            idIncreaseAuto = (productList.get(productList.size() - 1).getId()) + 1;
//        }
//        product.setId(idIncreaseAuto);
//        productList.add(product);
//    }

//    @Override
//    public Product findById(int id) {
//        return productList.get(id-1);
//    }

//    @Override
//    public void update(int id, Product product) {
//        productList.add(product);
//    }
//
//    @Override
//    public void remove(int id) {
//        productList.remove(id - 1);
//    }
//
//    public Integer getLasstId() {
//        int size = productList.size() - 1;
//        return size;
//    }

    public List<Product> seachingProduct(String name) {
        List<Product> productListSeaching = new ArrayList<>();
        for (Product product : productList) {
            if (product.getNameProduct().toLowerCase().contains(name.toLowerCase())) {
                productListSeaching.add(product);
            }
        }
        return productListSeaching;
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> musicTypedQuery = BaseRepository.
                entityManager.createQuery("select  m  from Product m", Product.class);
        return musicTypedQuery.getResultList();
    }

    @Override
    public Product findOne(Long id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void save(Product music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public void delete(Product music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();
        BaseRepository.entityManager.remove(music);
        entityTransaction.commit();
    }

    @Override
    public void update(Product music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }
}
