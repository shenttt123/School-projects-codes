"""

Complete the following methods in the code below!
search()
add()
size()
remove()
"""

class Node:
    def __init__(self,initdata):
        self.data = initdata
        self.next = None
        self.prev = None

    def getData(self):
        return self.data

    def getNext(self):
        return self.next

    def getPrev(self):
        return self.prev

    def setData(self,newdata):
        self.data = newdata

    def setPrev(self, newprev):
        self.prev = newprev

    def setNext(self,newnext):
        self.next = newnext


class OrderedDLList:
    def __init__(self):
        self.head = None
        self.tail = None

    def search(self, item):
        current = self.head
        found = False
        while current is not None:
            if current.getData() == item:
                return True
            current=current.getNext()
        return found

    def add(self, item):
        value = Node(item)
        value.setData(item)
        if self.head is None:
            self.head = value
            self.tail = value
        elif self.head.getData() >= item:
            value.setNext(self.head)
            self.head.setPrev(value)
            self.head = value
        elif self.tail.getData() <= item:
            value.setPrev(self.tail)
            self.tail.setNext(value)
            self.tail = value
        else:
            current = self.head
            while current.getData() < item:
                current = current.getNext()
            current.getPrev().setNext(value)
            value.setPrev(current.getPrev())
            value.setNext(current)
            current.setPrev(value)

    def isEmpty(self):
        return self.head == None

    def size(self):
        x=self.head
        size=0
        while x is not None:
            size=size+1
            x=x.getNext()
        return size

    def remove(self, item):
        current = self.head
        while current is not None:
            if current.getData() == item:
                x = current.getNext()
                y = current.getPrev()
                if y is not None:
                    y.setNext(x)
                else:
                    self.head = x
                if x is not None:
                    x.setPrev(y)
                else:
                    self.tail = y
                break
            current = current.getNext()

    def printList(self):
        current = self.head
        while current != None:
            print(current.getData())
            current = current.getNext()

    def printRevList(self):
        current = self.tail
        while current != None:
            print(current.getData())
            current = current.getPrev()


mylist = OrderedDLList()
mylist.add(10)
mylist.add(15)
mylist.add(20)
mylist.add(11)

print(mylist.search(11))

mylist.printList()
print()
mylist.printRevList()

mylist.remove(20)
print()
mylist.printList()
print()
mylist.printRevList()
