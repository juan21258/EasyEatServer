class CreateRestaurantes < ActiveRecord::Migration
  def change
    create_table :restaurantes do |t|
      t.string :descripcion

      t.timestamps null: false
    end
  end
end
