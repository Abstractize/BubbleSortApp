package com.example.gabab.bubblesortapp.ADT;

public class SingleList {
	//Atributos
		private Node head;
		private int length;
		//Constructor
	    public SingleList(){
	        int random = (int) ((Math.random()*21)+20);
	        for (int i=0; i < random; i++){
	            int random2 = (int) (Math.random()*101);
	            this.add(random2);
	        }
	    }
		//Validador de Lista Vacia
		public boolean empty(){
			return head == null;
		}

		//Getters y Setters
		public Node getHead() {
			return head;
		}

		public void setHead(Node head) {
			this.head = head;
		}

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}
		//Metodos
		public void add(int newValue){
	        Node aux = new Node(newValue);
	        if (empty()){
	            this.head = aux;
	            }
	         else{
	            Node next = head;
	            while(next.getNext() != null){
	                next = next.getNext();
	            }
	            next.setNext(aux);
	        }
	        length++;
	    }
		public boolean search(int reference){
			Node aux = head;
			boolean flag=false;
			while (aux != null && flag != true){
				if (reference == aux.getValue()){
					flag = true;
				}
				else{
					aux = aux.getNext();
				}
			}
		return flag;
		}
		public void delete(int reference){//Elimina un miembro por referencia
				if (head.getValue() == reference){
					head = head.getNext();
				}
				else{
					Node aux = head;
					while(aux.getNext().getValue() != reference){
						aux = aux.getNext();
					}
					Node next = aux.getNext().getNext();
					aux.setNext(next);
				}
				length--;
		}

		public void erase(){//Elimina la lista
			head = null;
			length = 0;
		}
		public int getValue(int pos) {//Obtener valor por referencia

				if (pos == 0){
					return head.getValue();
				}else {
					Node aux = head;
					for (int i = 0; i < pos; i++) {
						aux = aux.getNext();
					}
					return aux.getValue();
				}

		}
		public void setValue(int reference,int pos) {
			if(pos >= 0 && pos < length) {
				if (pos == 0){
					head.setValue(reference);
				}else {
					Node aux = head;
					for (int i = 0; i < pos; i++) {
						aux = aux.getNext();
					}
					aux.setValue(reference);
				}
			}
		}
		public String Print() {
			String string = "[";
			for (int i=0; i < this.length; i++) {
				if (i==this.length-1) {
					string += String.valueOf(this.getValue(i)+ "]");
				}else {
					string += String.valueOf(this.getValue(i))+ ",";
				}

			}
			System.out.println(string + "]");
			return string;
		}
	}
