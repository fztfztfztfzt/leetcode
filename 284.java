// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer next=null;
    private Iterator<Integer> iter;
    private boolean has;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        iter = iterator;
        has=true;
	    if(iter.hasNext()) next=iter.next();
        else has=false;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer temp = next;
        if(iter.hasNext()) next = iter.next();
        else has = false;
        return temp;
	}

	@Override
	public boolean hasNext() {
	    return has;
	}
}