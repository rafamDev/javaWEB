<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<div class="menu">
<button class="button ${param.seccion == 'personas' ? 'disabled' : ''}" type="button"  >Personas</button>
<button class="button ${param.seccion == 'ayudas_d' ? 'disabled' : ''}" type="button" >Ayudas Dependencia</button>
<button class="button ${param.seccion == 'ayudas_e' ? 'disabled' : ''}" type="button" >Ayudas Escolares</button>
<button class="button ${param.seccion == 'ucs' ? 'disabled' : ''}" type="button" >Unidades Convivencia</button>
</div>