class BdshowController < ApplicationController
  def form
  	@nombre = params[:nombre_usuario]#recibe el parametro nombre
  	
  end
end
