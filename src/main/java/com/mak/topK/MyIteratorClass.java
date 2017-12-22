package com.mak.topK;

import java.util.Iterator;

/**
 * Created by makai on 2017/12/16.
 */
public class MyIteratorClass implements Iterable {

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<TrieTree.TrieNode> {

        //返回时候还有下一个值
        @Override
        public boolean hasNext() {
            return false;
        }

        //返回下一个迭代值
        @Override
        public TrieTree.TrieNode next() {
            return null;
        }
    }
}
