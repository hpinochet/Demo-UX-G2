<template>
  <div id="example1" >
    <div class="cuadrado1" ></div>
    <div class="i-pad-pro111-container">
        <div class="i-pad-pro111-login">
          <div class="i-pad-pro111-logo">
            <img
              src="../playground_assets/imagen2022110220562846116177-tg1t-200h.png"
              alt="imagen2022110220562846116177"
              class="i-pad-pro111-imagen202211022056284611"
            />
          </div>
      </div>  
      <div class="inicio-sesion">
        <span>Inicio de sesión</span>
      </div>
      <div class="texto2">
        <span>Inversiones Royale</span>
      </div>
      <div class="texto3">
        <span>Rut</span>
      </div>
      <div class="texto4">
        <span>Contraseña</span>
      </div>
      <div class="texto5">
        <span v-on:click="construccion">¿Contraseña olvidada?</span>
      </div>
      <input v-model="rut" type="text" placeholder="Ej: 16.235.245-5"  class="i-pad-pro111-email" />
      <input v-if="show" v-model="contrasena" placeholder="●●●●●●●●●●●●●●"  class="i-pad-pro111-email-2" type="password"/>
      <input v-else v-model="contrasena" placeholder="●●●●●●●●●●●●●●"  class="i-pad-pro111-email-2" />

      <div v-if="show">
        <img
              src="../playground_assets/eye.png"
              alt="imagen2022110220562846116177"
              class="control"
              v-on:click="verContrasena"
            />
      </div>
      <div v-else>
        <img
              src="../playground_assets/eye-close.png"
              alt="imagen2022110220562846116177"
              class="control"
              v-on:click="verContrasena"
            />
      </div>
      <button v-on:click="cuenta" class="boton-ingreso"> <span class="texto-6">Iniciar Sesión</span>  </button>
      </div>
      <span class="texto7" v-if="show2">Ingrese un rut/Ingrese correctamente el rut.</span>
      <span class="texto8" v-if="show3">Ingrese una contraseña/Contraseña incorrecta.</span>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'IPadPro111',
  metaInfo: {
    title: 'exported project',
  },
  data(){
    return{
    contrasena:"",
    rut:"",
    respuesta: null,
    show:true,
    show2:false,
    show3:false
    }
  },
  methods:{
    verContrasena(){
      this.show=!this.show
    },
    async cuenta(){
      let id= "1"

      console.log(this.rut);
      console.log(this.contrasena);

      const payload = {
        username: this.rut,
        password: this.contrasena
      }

      const axiosInstance = axios.create({
              headers: {
                  "Access-Control-Allow-Origin": "*"
              }
      });

      await axiosInstance.post('http://localhost:8888/cuenta/login', payload)
      .then(response => {
        this.respuesta = response.data;
        console.log(this.respuesta);
        if(this.respuesta=="No existe una cuenta con este RUT"){
          this.show2=true;
        }
        else if (this.respuesta=="La contraseña de la cuenta es incorrecta"){
          this.show3=true
        }
        else{
          this.$router.push("/MisCuentas/"+this.respuesta)
        }
      })
      
      
      
    
      //this.$router.push("/MisCuentas/"+id)
    },
    construccion(){
      this.$router.push("/construccion")
    }
  }
}
</script>

<style scoped>
#example1 {
  background: url(../playground_assets/pexelspixabay6686917130-ayww-900h.png)no-repeat center center fixed;
  background-repeat: no-repeat;
  background-size: 100% 100%;
  width: 100vw;
  height: 100vh;
  display: flex;
  margin-bottom: 0px;
}
.i-pad-pro111-login {
  top: 155px;
  left: 504px;
  width: 385px;
  height: 438px;
  display: flex;
  padding: 24px;
  position: absolute;
  align-items: flex-start;
  flex-shrink: 0;
  border-color: transparent;
  border-radius: 4px;
  flex-direction: column;
  background-color: var(--dl-color-gray-white);
}
.i-pad-pro111-logo {
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: center;
  flex-shrink: 0;
  border-color: transparent;
  margin-bottom: 24px;
}
.i-pad-pro111-imagen202211022056284611 {
  width: 100px;
  height: 51px;
  position: relative;
  border-color: transparent;
  margin-right: 8px;
}
.inicio-sesion {
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 250px;
  left: 530px;
  font-size: 22px;
}
.texto2 {
  display: flex;
  position: relative;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  font-weight: bolder;
  top: 130px;
  left: 650px;
  font-size: 22px;
  color:#059669
}
.texto3 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  top: 320px;
  left: 550px;
  font-size: 17px;
}
.texto4 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  top: 420px;
  left: 550px;
  font-size: 17px;
}
.texto5 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  border-color: transparent;
  margin-bottom: 24px;
  flex-direction: column;
  top: 420px;
  left: 750px;
  font-size: 17px;
  cursor: pointer;
  color:#047857
}
.texto-6 {
  font-size: 17px;
  color:#ffffff
}
.texto7 {
  font-size: 17px;
  color: red;
  top: 390px;
  left: 550px;
  font-size: 17px;
  position:absolute;
}
.texto8 {
  font-size: 17px;
  color: red;
  top: 490px;
  left: 550px;
  font-size: 17px;
  position:absolute;
}
.i-pad-pro111-email {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  margin-bottom: 24px;
  flex-direction: column;
  box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25) ;
  box-sizing: border-box;
  top: 350px;
  left: 550px;
  width: 380px;
  height: 35px;
}
.i-pad-pro111-email-2 {
  display: flex;
  position: absolute;
  align-self: stretch;
  align-items: flex-start;
  margin-bottom: 24px;
  flex-direction: column;
  box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25) ;
  box-sizing: border-box;
  top: 450px;
  left: 550px;
  width: 380px;
  height: 35px;
}
.cuadrado1 {
  top:150px;
  left: 500px;
  width: 500px;
  height: 500px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgba(1, 73, 4, 1);
  border-style: solid;
  border-width: 1px;
  background-color: rgb(255, 255, 255);
  border-radius: 10px;
}
.boton-ingreso {
  top: 550px;
  left: 530px;
  width: 450px;
  height: 36px;
  position: absolute;
  box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25) ;
  box-sizing: border-box;
  object-fit: cover;
  border-color: rgb(14, 65, 15);
  border-style: solid;
  border-width: 1px;
  border-radius: 4px;
  background-color: rgb(4, 120, 87);
  cursor: pointer;
}
.control {
  top: 450px;
  left: 880px;
  width: 50px;
  height: 35px;
  position: absolute;
  box-sizing: border-box;
  object-fit: cover;
  border-style: solid;
  border-width: 1px;
  border-radius: 4px;
  cursor: pointer;
}
</style>
