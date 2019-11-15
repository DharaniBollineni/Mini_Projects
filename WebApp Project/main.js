 let mobileNav = document.getElementById('mobile-nav')
 
 mobileNav.addEventListener('click', function() {
 	if (this.style.height == '100vh') {
 		this.style.height = '1cm';
 	} else {
 		this.style.height = '100vh';
 	}
 })
 
 
 let sb = document.querySelector('.sb')
 let listItems = sb.getElementsByTagName('li')
 
 for (let i = 0; i < listItems.length; i++) {
 	listItems[i].addEventListener('click', function() {
 		let p = document.createElement('p')
 		// p.textContent = this.textContent
 		p.appendChild(document.createTextNode(this.textContent));
 		document.getElementsByTagName('main')[0].appendChild(p)
 	})
 }
 
 // document.getElementsByClassName('xx')
 // document.querySelectorAll('.xx')
 
 document.getElementById('thebutton').addEventListener('click', function() {
 	let name = document.querySelector('#user_name').value
 	let checked = document.getElementById('thecheckbox').checked
 	let word = document.querySelector('#thedropdown').value
 	
 	alert(word + ' ' + name + ' ' + checked);
 })
 
 function rainbowButtonHandler() {
 	let c = 0
 	let i = setInterval(function() {
 		document.body.style.background = 'hsl(' + c + ', 100%, 50%)'
 		c++
 		if (c >= 360) {
 			clearInterval(i)
 			document.body.style.background = 'white';
 		}
 	}, 10)
 }
 
 document.getElementById('rainbowButton').addEventListener('click',
 	rainbowButtonHandler);
 
 
 async function retrieveButtonHandler() {
 	let f = await fetch('data.txt')
 	let t = await f.text()
 	document.getElementById('retrieved-data').textContent = t
 }
 
 
document.getElementById('retrieveButton').addEventListener('click',
	retrieveButtonHandler);

var a = [1, 2, 3]
a[1] = "hello"
a.push("world")

let obj = {
	x: 5,
	y: 12,
	toString: function() { return "(" + this.x + ", " + this.y + ")" ; }
}


if (obj.toString) {
	console.log(obj.toString())
}

class Animal {
	constructor(name) {
		this.name = name
	}
	toString() {
		return "Animal called " + this.name;
	}
}

let an = new Animal("fred")
let b = new Animal("barney")

class Dog extends Animal {
	constructor(name) {
		super(name)
	}
}

let d = new Dog("wilma");

try {
	
} catch (e) {
	
}





