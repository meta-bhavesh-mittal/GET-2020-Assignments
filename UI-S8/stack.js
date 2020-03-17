stack = function() {
    this.items = [];
    this.add = function(element) {
        this.items.push(element);
    }
    this.pop = function() {
        return this.items.pop();
    }
    this.peek = function() {
        return this.items[this.items.length - 1];
    }
}




queue = function() {
    this.items = [];
    this.enqueue = function(element) {
        this.items.push(element);
    }
    this.dequeue = function() {
        return this.items.shift();
    }
}




