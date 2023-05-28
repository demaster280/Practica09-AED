/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package treelink;

import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;
public interface LinkBST<E> {
	void insert(E x) throws ItemDuplicated;
	void remove(E x);
	E search(E x) throws ItemNoFound;
	boolean isEmpty();
}