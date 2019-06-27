/**
 * Empresa.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre:{
      type:'string',
      required: true
    },

    usuariosDeEmpresa: {//nombre del atributo de la relación
      collection: 'usuario',//nombre del modelo a relacionar
      via: 'fkEmpresa'//nombre de atributo FK del otro modelo
    },
  },

};

