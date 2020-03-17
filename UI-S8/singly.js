Node = function(element) {
    this.element = element;
    this.next = null;
}

linkedlist = function() {
    this.head = null;
    this.size = 0;

    this.addlast = function(element) {
        var node = new Node(element);
        var curr;
        if (this.head == null) {
            this.head = node;
        } else {
            curr = this.head;
            while (curr.next) {
                curr = curr.next;
            }
            curr.next = node;
        }
        this.size++;
    }

    this.remove = function(element) {
        var curr = this.head;
        var prev = null;
        while (curr != null) {
            if (curr.element == element) {
                if (prev == null) {
                    this.head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                this.size--;
                return curr.element;
            }
            prev = curr;
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