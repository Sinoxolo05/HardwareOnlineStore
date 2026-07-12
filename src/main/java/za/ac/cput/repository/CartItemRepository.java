package za.ac.cput.repository;

import za.ac.cput.domain.CartItem;

import java.util.ArrayList;
import java.util.List;

/*
 * CartItemRepository.java
 * CartItem Repository using the Singleton Pattern
 * Author: Mfanafuthi Khumalo 230018270
 * Date: 12 July 2026
 */

public class CartItemRepository {

    private static CartItemRepository repository = null;
    private final List<CartItem> cartItemList;

    // Private constructor
    private CartItemRepository() {
        cartItemList = new ArrayList<>();
    }

    // Singleton access method
    public static CartItemRepository getRepository() {
        if (repository == null) {
            repository = new CartItemRepository();
        }
        return repository;
    }

    // Create
    public CartItem create(CartItem cartItem) {
        cartItemList.add(cartItem);
        return cartItem;
    }

    // Read
    public CartItem read(String cartItemId) {
        for (CartItem cartItem : cartItemList) {
            if (cartItem.getCartItemId().equals(cartItemId)) {
                return cartItem;
            }
        }
        return null;
    }

    // Update
    public CartItem update(CartItem updatedCartItem) {
        CartItem existing = read(updatedCartItem.getCartItemId());

        if (existing != null) {
            cartItemList.remove(existing);
            cartItemList.add(updatedCartItem);
            return updatedCartItem;
        }

        return null;
    }

    // Delete
    public boolean delete(String cartItemId) {
        CartItem cartItem = read(cartItemId);

        if (cartItem != null) {
            cartItemList.remove(cartItem);
            return true;
        }

        return false;
    }

    // Get All
    public List<CartItem> getAll() {
        return cartItemList;
    }
}