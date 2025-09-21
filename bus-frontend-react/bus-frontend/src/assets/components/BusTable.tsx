import React from 'react';
import type { Bus } from '../../types/Bus';

interface Props {
  buses: Bus[];
  onSelect: (id: number) => void;
}

const BusTable: React.FC<Props> = ({ buses, onSelect }) => {
  return (
    <table className="table table-hover table-bordered mt-3">
      <thead className="table-dark">
        <tr>
          <th>ID</th>
          <th>Número</th>
          <th>Placa</th>
          <th>Marca</th>
          <th>Activo</th>
        </tr>
      </thead>
      <tbody>
        {buses.map(bus => (
          <tr key={bus.id} onClick={() => onSelect(bus.id)} style={{ cursor: 'pointer' }}>
            <td>{bus.id}</td>
            <td>{bus.numeroBus}</td>
            <td>{bus.placa}</td>
            <td>{bus.marca.nombre}</td>
            <td>{bus.activo ? 'Sí' : 'No'}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default BusTable;