function res = ElektriskKraft(F, q, E)
if F == 0
	res = q*E;
elseif q == 0
	res = F/E;
elseif E == 0
	res = F/q;
end

