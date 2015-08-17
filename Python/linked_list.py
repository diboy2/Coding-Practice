class Node:

	def __init__(self, initdata):
		self.data = initdata
		self.next = None

	def getData(self):
		return self.data

	def setData(self, newdata):
		self.data = newdata

	def getNext(self):
		return self.next

	def setNext(self, newnext):
		return self.next = newnext


class Linked_List:

	def __init__(self):
		self.head = None

	def add(self, item):
		temp = Node(newdata)
		temp.setNext(self.head)
		self.head = temp

	def remove(self, item):
		current = self.head
		previous = None

		while(current is not None):
			if (current.getData() == item):
				if previous is None:
					self.head = current.getNext()
					current.setNext(None)
				else:
					previous.next = current.getNext()
					current.setNext(None)

			current = current.getNext()	
		else:
			print("Item not found")

	def search(self, item):
		temp = self.head 

		while (temp is not None):
			if temp.getData() == item:
				return True
			temp = temp.getNext()
		return False

	def isEmpty(self):
		return (self.head is None)	


	def size(self):
		temp = self.head

		counter = 0
		while(temp is not None):
			counter++
			temp = temp.getNext()
		return counter

	def index(self, item):
		temp = self.head

		count = --self.size()
		while(temp is not None):
			count--
			temp = temp.getNext()

	def insert(self, pos, item):
		
		current = self.head

		previous = None

		count = --self.size()
		while(count != pos):
			count--
			previous = current
			current = current.getNext()

		if(previous is None):
			newNode = Node(item)
			newNode.setNext(current)
		else:
			newNode = Node(item)
			newNode.setNext(current)
			previous.next = newNode

	def pop(self):
		if(not self.isEmpty()):
			lastNode = self.head 

			self.head = self.head.getNext()

			return lastNode.getData()

	def pop(self, pos):
		