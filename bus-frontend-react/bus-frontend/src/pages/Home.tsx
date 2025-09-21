import React, { useEffect, useState } from 'react';
import type { Bus } from '../types/Bus';
import { fetchBuses, fetchBusById } from '../services/busService';
import BusTable from '../assets/components/BusTable';

const Home: React.FC = () => {
  const [buses, setBuses] = useState<Bus[]>([]);

  useEffect(() => {
    fetchBuses()
      .then((data: Bus[]) => setBuses(data))
      .catch((err: unknown) => console.error('Error al obtener buses:', err));
  }, []);

  const handleSelectBus = async (id: number) => {
    try {
      const bus: Bus = await fetchBusById(id);
      alert(
        `Bus seleccionado:\n\n` +
        `Número: ${bus.numeroBus}\n` +
        `Placa: ${bus.placa}\n` +
        `Marca: ${bus.marca.nombre}\n` +
        `Características: ${bus.caracteristicas}\n` +
        `Activo: ${bus.activo ? 'Sí' : 'No'}\n` +
        `Fecha de creación: ${new Date(bus.fechaCreacion).toLocaleDateString('es-PE')}`
      );
    } catch {
      alert('No se pudo obtener el bus');
    }
  };

  return (
    <div className="container">
      <h2 className="text-center mt-4">Lista de Buses</h2>
      <BusTable buses={buses} onSelect={handleSelectBus} />
    </div>
  );
};

export default Home;