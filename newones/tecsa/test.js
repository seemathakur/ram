var assert = require('assert');
var transformer = require('./index.js');


describe('mbtransformer', function(){
	it('', function(){
		transformer();
		var response = {};
		transformer(null, response);
		
	})
	it('', function(){
		var response = {body:JSON.stringify({field:'http://www.google.com'})};
		transformer(null, response);
		assert.equal('http://localhost:3535/', response.body.field)
	})
	it('', function(){
		var response = {body:JSON.stringify({field:'http://www.google.com/path'})};
		transformer(null, response);
		assert.equal('http://localhost:3535/path', response.body.field)
	})
	it('', function(){
		var response = {body:JSON.stringify({field1:'http://www.google.com/path',field2:'http://www.google.com/path'})};
		transformer(null, response);
		assert.equal('http://localhost:3535/path', response.body.field1);
		assert.equal('http://localhost:3535/path', response.body.field2);
	})
	it('', function(){
		var response = {body:JSON.stringify({field1:'http://www.google.com/path',field2:'http://www.google.com/path',field3:1})};
		transformer(null, response);
		assert.equal('http://localhost:3535/path', response.body.field1);
		assert.equal('http://localhost:3535/path', response.body.field2);
		assert.equal(1, response.body.field3);
	})
	it('', function(){
		var response = {body:JSON.stringify({field1:'http://www.google.com/path',field2:'http://www.google.com/path',field3:1,nestedObject:{nestedObjectField1:"http://www.google.com/path",nestedObjectField2:"http://www.google.com/path",nestedObjectField3:1}})};
		transformer(null, response);
		assert.equal('http://localhost:3535/path', response.body.field1);
		assert.equal('http://localhost:3535/path', response.body.field2);
		assert.equal(1, response.body.field3);
		assert.equal('http://localhost:3535/path', response.body.nestedObject.nestedObjectField1);
		assert.equal('http://localhost:3535/path', response.body.nestedObject.nestedObjectField2);
		assert.equal(1, response.body.nestedObject.nestedObjectField3);
	})
	it('', function(){
		var response = {body:JSON.stringify({field1:'http://www.google.com/path',field2:'http://www.google.com/path',field3:1,arrayOfNestedObjects:[{nestedInArrayObject1Field1:"http://www.google.com/path",nestedInArrayObject1Field2:"http://www.google.com/path",nestedInArrayObject1Field3:1},{nestedInArrayObject2Field1:"http://www.google.com/path",nestedInArrayObject2Field2:"http://www.google.com/path",nestedInArrayObject2Field3:1}]})};
		transformer(null, response);
		assert.equal('http://localhost:3535/path', response.body.field1);
		assert.equal('http://localhost:3535/path', response.body.field2);
		assert.equal('http://localhost:3535/path', response.body.arrayOfNestedObjects[0].nestedInArrayObject1Field1);
		assert.equal('http://localhost:3535/path', response.body.arrayOfNestedObjects[0].nestedInArrayObject1Field2);
		assert.equal(1, response.body.arrayOfNestedObjects[0].nestedInArrayObject1Field3);
		assert.equal('http://localhost:3535/path', response.body.arrayOfNestedObjects[1].nestedInArrayObject2Field1);
		assert.equal('http://localhost:3535/path', response.body.arrayOfNestedObjects[1].nestedInArrayObject2Field2);
		assert.equal(1, response.body.arrayOfNestedObjects[1].nestedInArrayObject2Field3);
		
	})
})