import type { NextPage } from "next";
import React, { useState } from "react";
import axios from "axios";

const Home: NextPage = () => {
  const [name, setName] = useState<string>("");
  const [email, setEmail] = useState<string>("");
  const [age, setAge] = useState<string>("");

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:8080/api/student", {
        name,
        email,
        age: parseInt(age),
      });
      alert("Success");
    } catch (err: unknown) {
      console.log(err);
    }
  };

  return (
    <body>
      <header className="max-w-lg mx-auto">
        <h1 className="text-4xl font-bold text-white text-center">Startup</h1>
      </header>

      <main className="bg-white max-w-lg mx-auto p-8 md:p-12 my-10 rounded-lg shadow-2xl">
        <section>
          <h3 className="font-bold text-2xl">Create a Student</h3>
        </section>

        <section className="mt-10">
          <form className="flex flex-col" onSubmit={handleSubmit}>
            <div className="mb-6 pt-3 rounded bg-gray-200">
              <label className="block text-gray-700 text-sm font-bold mb-2 ml-3">
                Name
              </label>
              <input
                type="text"
                className="bg-gray-200 rounded w-full text-gray-700 focus:outline-none border-b-4 border-gray-300 focus:border-purple-600 transition duration-500 px-3 pb-3"
                value={name}
                onChange={(e) => setName(e.target.value)}
              />
            </div>

            <div className="mb-6 pt-3 rounded bg-gray-200">
              <label className="block text-gray-700 text-sm font-bold mb-2 ml-3">
                Age
              </label>
              <input
                type="number"
                className="bg-gray-200 rounded w-full text-gray-700 focus:outline-none border-b-4 border-gray-300 focus:border-purple-600 transition duration-500 px-3 pb-3"
                value={age}
                onChange={(e) => setAge(e.target.value)}
              />
            </div>

            <div className="mb-6 pt-3 rounded bg-gray-200">
              <label className="block text-gray-700 text-sm font-bold mb-2 ml-3">
                Email
              </label>
              <input
                type="text"
                className="bg-gray-200 rounded w-full text-gray-700 focus:outline-none border-b-4 border-gray-300 focus:border-purple-600 transition duration-500 px-3 pb-3"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
            </div>

            <button
              className="bg-purple-600 hover:bg-purple-700 text-white font-bold py-2 rounded shadow-lg hover:shadow-xl transition duration-200"
              type="submit"
            >
              Create
            </button>
          </form>
        </section>
      </main>

      <footer className="max-w-lg mx-auto flex justify-center">
        <a href="/students" className="hover:underline">
          View Students
        </a>
      </footer>
    </body>
  );
};

export default Home;
