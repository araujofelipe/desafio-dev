import moment from "moment";
import React, { useEffect } from "react";
import NumberFormat from "react-number-format";
import styles from "./ListTransactions.module.css";

const ListTransactions = ({ store, data }) => {
  useEffect(() => {
    console.log(data);
  });
  return (
    <>
      <p>Store: {store} </p>
      Transactions
      <table>
        <thead>
          <th>Type</th>
          <th>Value</th>
          <th>Date</th>
        </thead>
        <tbody>
          {data?.map((transaction, index) => (
            <tr key={`transaction-${index}-${store}`}>
              <td>{transaction.type}</td>
              <td>
                <NumberFormat
                  value={transaction.value}
                  displayType={"text"}
                  thousandSeparator={","}
                  prefix={"R$"}
                />
              </td>
              <td>
                {" "}
                <time className="time text-center" dateTime={transaction.date}>
                  {moment(transaction.date).format("DD/MM/yyyy")}
                </time>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
};

export default ListTransactions;
