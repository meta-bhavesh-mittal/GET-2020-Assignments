Node = function(element) {
    this.prev = null;
    this.element = element;
    this.next = null;
}

linkedlist = function() {
    this.head = null;
    this.size = 0;

    this.add = function(element) {
        var node = new Node(element);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
        }
        this.size++;
    }

    this.remove = function(element) {
        var curr = this.head;
        while (curr != null) {
            if (curr.element == element) {
                curr.prev.next = curr.next;
                this.size--;
                return curr.element;
            }
            curr = curr.next;
        }
        return -1;
    }

    this.show = function() {
        var curr = this.head;
        while (curr != null) {
            console.log(curr.element);
            curr = curr.next;
        }
    }
}