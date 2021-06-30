/**
 * 
 */

function setAttribute(id, value, typeAttribute) {
	const el = document.getElementById(id);
	classAttribute = document.createAttribute(typeAttribute);
	classAttribute.value = value;
	el.setAttributeNode(classAttribute);
}

function setColor(ids, correctId) {
	ids.forEach(element => {
		if (element != correctId) {
			document.getElementById(element).style.color = 'black';
		} else if (element == correctId) {
			document.getElementById(element).style.color = 'white';
		}	
	})
}

function setBarMenu(num) {
	setAttribute('l' + num,'active','class');
	setColor(['a1','a2','a3','a4','a5'], 'a' + num);
}

function setActive() {
	switch(window.location.pathname.split(`/`)[2]) {
		case 'index.jsp':
		case '':
			setBarMenu('1'); break;
		case 'listaprodotti.jsp':
			setBarMenu('2'); break;
		case 'offerte.jsp':
			setBarMenu('3'); break;
		case 'categorie.jsp':
			setBarMenu('4'); break;
		case 'contatti.jsp':
			setBarMenu('5'); break;
	}

}
