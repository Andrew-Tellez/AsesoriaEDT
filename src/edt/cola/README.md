# Cola

## Caracteristicas
la cola se compone de nodos que se van referenciando unos a otros
es decir que tienen nocion del siguiente nodo.

contiene dos atributos importante: 
- la raiz
- el fondo

estos dos son importantes ya que nos permiten poder seguir
almacenando referencias de memoria

dentro del metodo *encolar* en la clase *Cola*
~~~
	public void encolar(int numero) {
		Nodo nuevo = new Nodo(numero);
		if (esLleno()){	
			System.out.println("La cola esta llena debes desencolar para almacenar mas");
		}else if(esVacio()){
			raiz = nuevo;
			System.out.println(raiz);
			fondo = nuevo;
			posicion++;
		}else{
			fondo.siguiente = nuevo;
			fondo = nuevo;
			System.out.print(raiz+ "\n");
			posicion++;
		}
	}
~~~
tenemos la *raiz y el *fondo* cada uno de ellos es un nodo, 
la parte escencial aqui es que cuando creamos un nuevo nodo en la sentencia
~~~
Nodo nuevo = new Nodo(numero);
~~~
nosotros creamos un objeto, pero tambien una direccion de memoria hacia la cual 
apuntar con el *raiz* y el *fondo* esto ocurre por el operador de asignacion

entonces siempre *raiz* va a saber lo que le esta pasando a *fondo* porque 
comparten la misma direccion de memoria, incluso si no actualizamos la raiz 
como es el caso de 
~~~
fondo.siguiente = nuevo;
fondo = nuevo;
~~~
aqui lo que le ocurre a fondo siguiente es por la clase *Nodo* que tiene la propiedad 
de otro nodo que al principio está en *NULL* pero luego le asignamos valor con el nuevo 
que ingresemos, esto hará que *raiz* se actualize tambien y esto es porque la raiz desde 
que compartio direccion de memoria con el primer nodo que se colocó, automaticamente va 
a actualizarse el valor de los nodos consecutivos.

ahora la importancia de 
~~~
fondo = nuevo;
~~~
esté es importante debido a que se tiene que volver a colocar en *NULL* el valor del 
siguiente nodo ya que este nos permitirá volver a colocar otro, mientras no excedamos 
el limite maximo.

